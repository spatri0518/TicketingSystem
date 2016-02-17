package com.walmart.ts.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.apache.commons.lang.StringUtils;

/**
 * Utility class for Date operations.
 */
public class DateUtility {

    public static final String UTC_DATE_TIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ssZ";

    /**
     * Put the most restrictive date formats first
     */

	private static final ThreadLocal<SimpleDateFormat> simpleDateFormat;

    static
 {
		simpleDateFormat = new ThreadLocal<SimpleDateFormat>() {
			@Override
			protected SimpleDateFormat initialValue() {
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
						UTC_DATE_TIME_FORMAT, Locale.getDefault());
				simpleDateFormat.setLenient(false);
				return simpleDateFormat;
			}
		};

	}

	public static String formatSimpleLiteralDate(Date date)
    {
        if (date == null)
        {
            return null;
        }
		return simpleDateFormat.get().format(date);
    }

    /**
     * 
     * @param date
     * @return
     */
    public static Date parseSimpleLiteralDate(String date)
    {
        try
        {
            if (StringUtils.isNotEmpty(date))
            {
				return simpleDateFormat.get().parse(date);
            }
        }
        catch (ParseException e)
        {
            return null;
        }
        return null;
    }

}
