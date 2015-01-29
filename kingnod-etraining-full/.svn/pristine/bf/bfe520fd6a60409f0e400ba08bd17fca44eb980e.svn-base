package com.kingnod.etraining.course.exception;

public class LMSException extends Exception {
  
  //错误码
  protected String errorCode;

  public LMSException()
  {
      super();
  }
  public LMSException(String errorCode)
  {
      super();
      setErrorCode(errorCode);
  }

  public LMSException(String errorCodes, String errorInfo)
  {
      super(errorInfo);
      setErrorCode(errorCodes);
  }

  public LMSException(String errorCodes, Throwable throwable)
  {
      this(errorCodes, throwable.getMessage());
  }

  public LMSException(Throwable throwable)
  {
      this("101", throwable);
  }
  
  public String getErrorCode() {
    return errorCode;
  }

  public void setErrorCode(String errorCode) {
    this.errorCode = errorCode;
  }

}
