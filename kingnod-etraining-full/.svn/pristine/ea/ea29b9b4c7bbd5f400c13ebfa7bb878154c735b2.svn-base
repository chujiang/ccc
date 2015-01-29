package com.kingnod.etraining.course.parsescorm;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import org.jdom.Element;
import org.jdom.JDOMException;
import org.springframework.stereotype.Component;

import com.kingnod.core.criteria.Cnd;
import com.kingnod.core.criteria.CriteriaBuilder;
import com.kingnod.core.exception.Exceptions;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.core.util.SpringUtils;
import com.kingnod.etraining.course.CourseConstant;
import com.kingnod.etraining.course.contentpackage.CP_Core;
import com.kingnod.etraining.course.contentpackage.SCORM12_Core;
import com.kingnod.etraining.course.exception.DocumentHandlerException;
import com.kingnod.etraining.course.exception.NoItemFoundException;
import com.kingnod.etraining.course.entity.CourseInfo;
import com.kingnod.etraining.course.entity.ItemInfo;
import com.kingnod.etraining.course.parsexmlutil.XMLDocument;
import com.kingnod.etraining.course.service.CourseInfoService;
import com.kingnod.etraining.course.service.ItemInfoService;

@Component
public class ScormPackageHandler extends XMLDocument {

	public static final String ARCHIVE_EXTENSION = ".zip";
	// public static final String XML_EXTENSION = ".xml";

	/**
	 * A xml file to hold the state of the course - which items have been
	 * completed etc.
	 */
	// protected SequencerModel _sequencerModel;

	/**
	 * A var to flag if any item were found in the manifest. If there are none
	 * found then this package cannot be played and/or is a resource package.
	 */
	public boolean _hasItemsToPlay = false;

	/**
	 * Default org id
	 */
	protected String _currentOrgId;

	/**
	 * Our instance of core scorm methods
	 */
	protected SCORM12_Core _scormCore;

	/**
	 * Name of the project
	 */
	public String _projectName;

	/**
	 * Default Constructor
	 */
	public ScormPackageHandler(File manifest) throws JDOMException, IOException {
		loadDocument(manifest);
		_scormCore = new SCORM12_Core(this);
	}

	@SuppressWarnings("unused")
	public boolean buildSettings(File zipFile , String folder,Long folderId,Long contentServerId) throws NoItemFoundException {
		List<ItemInfo> itemList = new ArrayList<ItemInfo>();
		Element manifestRoot = (Element) getDocument().getRootElement().clone();
		if (manifestRoot != null) {
			List<ItemInfo> orgList = new ArrayList<ItemInfo>();
			ItemInfo lmsItemInfo = new ItemInfo();
			CourseInfo courseInfo = new CourseInfo();
			Long courseId = 0L;
			Element orgs = manifestRoot.getChild(SCORM12_Core.ORGANIZATIONS,
					manifestRoot.getNamespace());
			Element defaultOrgNode = getDefaultOrganization(orgs);
			if (defaultOrgNode != null) {
				String title = getTitleElement(defaultOrgNode);
				if (title != null || title != "") {
					courseInfo.setCourseTitle(title);
					} else {
						courseInfo.setCourseTitle(zipFile.getName().substring(
							0,
							zipFile.getName().lastIndexOf(
									CourseConstant.COURSE_SEPARATOR)));
					}
				CriteriaBuilder builder = Cnd.builder(CourseInfo.class);
				builder.andEQ("courseTitle", courseInfo.getCourseTitle()).andEQ("folderId", folderId);
				PagingResult<CourseInfo> findCourse = SpringUtils.getBean(
						CourseInfoService.class).findCourseInfo(
						builder.buildCriteria());
				if(findCourse.getResult().size()>0){
					throw Exceptions.createAppException("crs001017");
				}
				courseInfo.setType(CourseConstant.COURSE_TYPE_SCORM);
				courseInfo.setCostType(CourseConstant.COURSE_COST_PERSONAL);
				courseInfo.setLocation(folder);
				courseInfo.setFolderId(folderId);
				courseInfo.setControl(0L);
				courseInfo.setContentServerId(contentServerId);
				SpringUtils.getBean(CourseInfoService.class).saveCourseInfo(
						courseInfo);
				builder.andEQ("location", courseInfo.getLocation());
				PagingResult<CourseInfo> findCourseInfo = SpringUtils.getBean(
						CourseInfoService.class).findCourseInfo(
						builder.buildCriteria());
				List<CourseInfo> result = findCourseInfo.getResult();
				for (Iterator<CourseInfo> iterator = result.iterator(); iterator
						.hasNext();) {
					CourseInfo info = iterator.next();
					courseId = info.getId();
				}
			} else {
				return _hasItemsToPlay = false;
			}
			String name = defaultOrgNode.getName();
			if (name.equals(CP_Core.ORGANIZATION)) {
				Element resources = manifestRoot.getChild(SCORM12_Core.RESOURCES,
						manifestRoot.getNamespace());
						List<Element> resourceItems = resources.getChildren(
							SCORM12_Core.RESOURCE, resources.getNamespace());
				iterateThruManifest(defaultOrgNode, lmsItemInfo,
						courseId,resourceItems);
			}
			_hasItemsToPlay = true;
		} else {
			throw new NoItemFoundException(
					NoItemFoundException.NO_ITEM_FOUND_MSG);
		}
		if (!_hasItemsToPlay) {
			throw new NoItemFoundException(
					NoItemFoundException.NO_ITEM_FOUND_MSG);
		}
		return _hasItemsToPlay;
	}

	@SuppressWarnings({ "rawtypes", "null", "unchecked" })
	public boolean iterateThruManifest(Element defaultOrgNode,
			ItemInfo lmsItemInfo, Long courseId,List<Element> resourceItems) {
		if (defaultOrgNode == null
				&& defaultOrgNode.getChildren().iterator().next() == null)
			return false;
		Iterator items = defaultOrgNode.getChildren("item",
				defaultOrgNode.getNamespace()).iterator();
		while (items.hasNext()) {
			ItemInfo itemInfo = new ItemInfo();
			Element item = (Element) items.next();
			itemInfo.setCourseId(courseId);
			itemInfo.setIdentifierRef(lmsItemInfo.getIdetifier());
			itemInfo.setParentUuid(lmsItemInfo.getUuid());
			itemInfo.setUuid(UUID.randomUUID().toString());
			itemInfo.setIdetifier(item.getAttributeValue(CP_Core.IDENTIFIER));
			itemInfo.setIdentifierRef(item
					.getAttributeValue(CP_Core.IDENTIFIERREF));
			itemInfo.setItemTitle(item.getChildTextTrim("title",
					item.getNamespace()));
			setItemForRes(itemInfo,resourceItems);
			saveItem(itemInfo);
			iterateThruManifest(item, itemInfo, courseId,resourceItems);
		}
		return true;
	}

	public Element getresElement(String identifier,List<Element> resItems){
			Element resItem = null;
			for (Iterator<Element> resourceItems= resItems.iterator(); resourceItems.hasNext();) {
				resItem = (Element) resourceItems.next();
				String residattribute = resItem.getAttributeValue(
						SCORM12_Core.IDENTIFIER, resItem.getNamespace());
				if (residattribute == null || residattribute.length() == 0) {
					residattribute = resItem
							.getAttributeValue(SCORM12_Core.IDENTIFIER);
				}
				if (residattribute != null
						&& residattribute.equals(identifier)) {
					return resItem;
				}else{
					resItem = null;
				}
			}
			return resItem;
	}
	
	public void setItemForRes(ItemInfo itemInfo,List<Element> resourceItems){
				Element resItem = getresElement(itemInfo.getIdentifierRef(),resourceItems==null?new ArrayList<Element>():resourceItems);
				if(null != resItem){
				itemInfo.setScoIdetifier(itemInfo.getIdentifierRef());
				itemInfo.setScoType(resItem.getAttributeValue(
							SCORM12_Core.SCORMTYPE,
							resItem.getNamespace("adlcp")));
				itemInfo.setLaunch(resItem
							.getAttributeValue(SCORM12_Core.HREF));
				}
		
	}

	public void saveItem(ItemInfo itemInfo){
		CriteriaBuilder builder = Cnd.builder(ItemInfo.class);
		if (null == itemInfo.getParentUuid()) {
			builder.andIsNull("uuid");
		} else {
			builder.andEQ("uuid", itemInfo.getParentUuid());
		}
		PagingResult<ItemInfo> result = SpringUtils.getBean(
				ItemInfoService.class).findItemInfo(
				builder.buildCriteria());
		if (null != result) {
			List<ItemInfo> allList = result.getResult();
			if (!allList.isEmpty()) {
				for (Iterator<ItemInfo> itemiter = allList.iterator(); itemiter
						.hasNext();) {
					ItemInfo item = itemiter.next();
					itemInfo.setItemParent(item.getId());
					SpringUtils.getBean(ItemInfoService.class)
							.saveItemInfo(itemInfo);
				}
			}else{
				SpringUtils.getBean(ItemInfoService.class).saveItemInfo(
						itemInfo);
			}
		} else {
			SpringUtils.getBean(ItemInfoService.class).saveItemInfo(
					itemInfo);
		}
	}
	public File getScoSettings(String _projectName, String scoID) {
		return new File(_projectName.concat(File.separator)
				.concat("Lms-sequence").concat(File.separator).concat(scoID)
				.concat(".xml"));
	}

	/**
	 * getDefaultOrganization - wraps the same method found in SCORM1_2Core.
	 * 
	 * @param orgs
	 * @return - the JDOM element representing the default organization
	 */
	public Element getDefaultOrganization(Element orgs) {
		return _scormCore.getDefaultOrganization(orgs);
	}

	/**
	 * getReferencedElement - wraps the same method found in SCORM1_2Core.
	 * 
	 * @param sourceElement
	 * @return - the JDOM element representing the resource
	 */
	public Element getReferencedElement(Element sourceElement) {
		return _scormCore.getReferencedElement(sourceElement);
	}

	public String getTitleElement(Element org) {
		return _scormCore.getTitle(org);
	}

	/**
	 * @return True if this is a Manifest that we can handle
	 */
	public boolean isSCORM12Manifest() throws DocumentHandlerException {
		// Has to be a CP Package with a SCORM 1.2 Namespace in there
		return SCORM12_DocumentHandler.canHandle(getDocument());
	}

}
