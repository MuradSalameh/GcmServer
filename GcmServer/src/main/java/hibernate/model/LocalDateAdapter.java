package main.java.hibernate.model;

import java.time.LocalDate;
import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * Adapter (for JAXB) to convert between the LocalDate and the ISO 8601 
 * String representation of the date such as '2012-12-03'.
 * 
 * @author Lyan Dwi Pangestu
 */
public class LocalDateAdapter extends XmlAdapter<String, LocalDate> {

	@Override
	public LocalDate unmarshal(String v) throws Exception {
		return LocalDate.parse(v);
	}

	@Override
	public String marshal(LocalDate v) throws Exception {
		return v.toString();
	}



	/*
	 * import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class DateAdapter extends XmlAdapter<String, Date> {
 // the desired format
 private String pattern = "yyyy-MM-dd";

 public String marshal(Date date) throws Exception {
 return new SimpleDateFormat(pattern).format(date);
 }

 public Date unmarshal(String dateString) throws Exception {
 return new SimpleDateFormat(pattern).parse(dateString);
 }
}
	 */
}

