package com.microservices.test.limitsservice.bean;

//@Component  
//@ConfigurationProperties("limits-service")  
public class Configuration   
{  
private int maximum;  
private int minimum;  
public void setMaximum(int maximum)   
{  
this.maximum = maximum;  
}  
public void setMinimum(int minimum)   
{  
this.minimum = minimum;  
}  
public int getMaximum()   
{  
return maximum;  
}  
public int getMinimum()   
{  
return minimum;  
}  
}  