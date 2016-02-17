package com.walmart.ts.util;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;

import com.walmart.ts.dto.CommonErrorCodeEnumDto;
import com.walmart.ts.exception.DataInvalidException;

/**
 * Utility class for Assertions.
 *
 */
public class Assert
{

    public static void assertNotEmpty(String attributeName, String value)
    {
        if (StringUtils.isEmpty(value))
        {
			throw new DataInvalidException(
					CommonErrorCodeEnumDto.INVALID_INPUT_DATA, "Invalid "
							+ attributeName + ":"
                    + attributeName + " must not be null/empty");
        }
    }

    public static void assertNotNull(String attributeName, Object value)
    {
        if (value == null)
        {
			throw new DataInvalidException(
					CommonErrorCodeEnumDto.INVALID_INPUT_DATA, "Invalid "
							+ attributeName + ":"
                    + attributeName + " must not be null/empty");
        }
    }

    public static void assertValidDate(String attributeName, String value)
    {
        if (StringUtils.isNotEmpty(value) && DateUtility.parseSimpleLiteralDate(value) == null)
        {
			throw new DataInvalidException(
					CommonErrorCodeEnumDto.INVALID_DATA_FORMAT, "Invalid "
							+ attributeName + "."
                    + attributeName + " must be in the format 'YYYY-MM-DD'.");
        }
    }

    public static void assertNotEmpty(String attributeName, List<? extends Object> valuesList)
    {
        if (valuesList == null || CollectionUtils.isEmpty(valuesList))
        {
			throw new DataInvalidException(
					CommonErrorCodeEnumDto.INVALID_INPUT_DATA, "Invalid "
							+ attributeName + ":"
                    + attributeName + " must not be null/empty");
        }
    }

    public static void assertMaxLength(String attributeName, String value, int maxLength)
    {
        if (value != null && value.length() > maxLength)
        {
			throw new DataInvalidException(
					CommonErrorCodeEnumDto.INVALID_INPUT_DATA, "Invalid "
							+ attributeName + ":"
                    + attributeName + " must not exceed " + maxLength + " characters.");
        }
    }

    public static void assertValidNumber(String attributeName, String value)
    {
        if (StringUtils.isNotEmpty(value) && !NumberUtils.isNumber(value))
        {
			throw new DataInvalidException(
					CommonErrorCodeEnumDto.INVALID_INPUT_DATA, "Invalid "
							+ attributeName + ":"
                    + attributeName + " must be a number.");
        }
    }

    public static void assertValidDecimal(String elementName, String value)
    {
        if (StringUtils.isNotEmpty(value) && !NumberUtils.isDigits(value))
        {
			throw new DataInvalidException(
					CommonErrorCodeEnumDto.INVALID_INPUT_DATA, elementName
                    + " must be a valid number.");
        }
    }

}
