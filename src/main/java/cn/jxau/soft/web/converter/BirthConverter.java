package cn.jxau.soft.web.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

@SuppressWarnings("rawtypes")
public class BirthConverter extends StrutsTypeConverter {
	private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	@Override
	public Object convertFromString(Map context, String[] values, Class toClass) {
		Date data = null;
		try {
			if (values[0] != null && ! values[0].equals("")) {
				data = format.parse(values[0]);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return data;
	}

	@Override
	public String convertToString(Map context, Object o) {
		String dateStr = null;
		if (o != null) {
			Date date = (Date) o;
			dateStr = format.format(date);
		}
		return dateStr;
	}

}
