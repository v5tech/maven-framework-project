package com.fengjing.framework.spring.dwr;

import java.awt.Color;

public class ColorUtil {
	
	 /**
     * Decode an HTML color string like '#F567BA;' into a {@link Color}
     * @param colorString The string to decode
     * @return The decoded color
     * @throws IllegalArgumentException if the color sequence is not valid
     */
    public static Color decodeHtmlColorString(String colorString)
    {
        Color color;
    
        if (colorString.startsWith("#"))
        {
            colorString = colorString.substring(1);
        }
        if (colorString.endsWith(";"))
        {
            colorString = colorString.substring(0, colorString.length() - 1);
        }
    
        int red;
        int green;
        int blue;
        switch (colorString.length())
        {
        case 6:
            red = Integer.parseInt(colorString.substring(0, 2), 16);
            green = Integer.parseInt(colorString.substring(2, 4), 16);
            blue = Integer.parseInt(colorString.substring(4, 6), 16);
            color = new Color(red, green, blue);
            break;
        case 3:
            red = Integer.parseInt(colorString.substring(0, 1), 16);
            green = Integer.parseInt(colorString.substring(1, 2), 16);
            blue = Integer.parseInt(colorString.substring(2, 3), 16);
            color = new Color(red, green, blue);
            break;
        case 1:
            red = green = blue = Integer.parseInt(colorString.substring(0, 1), 16);
            color = new Color(red, green, blue);
            break;
        default:
            throw new IllegalArgumentException("Invalid color: " + colorString);
        }
        return color;
    }
}
