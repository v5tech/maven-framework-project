package com.fengjing.framework.spring.dwr;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;

import org.directwebremoting.annotations.RemoteMethod;
import org.directwebremoting.annotations.RemoteProxy;
import org.directwebremoting.io.FileTransfer;

import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

/**
 * A demonstration of uploading files and images
 * @author Joe Walker [joe at getahead dot ltd dot uk]
 */
@RemoteProxy(name="dwrFileUtil")
public class DWRFileUtil
{
    /**
     * Take 2 uploaded files and return an image based on them
     * @param uploadImage The uploaded image
     * @param uploadFile The uploaded file
     * @param color The selected color
     * @return A mangled image based on the 2 uploaded files
     */
	@RemoteMethod
    public BufferedImage uploadFiles(BufferedImage uploadImage, String uploadFile, String color)
    {
        uploadImage = scaleToSize(uploadImage);
        uploadImage = grafitiTextOnImage(uploadImage, uploadFile, color);

        return uploadImage;
    }

    /**
     * Generates a PDF file with the given text
     * http://itext.ugent.be/itext-in-action/
     * @return A PDF file as a byte array
     */
    @RemoteMethod
    public FileTransfer downloadPdfFile(String contents) throws Exception
    {
        if (contents == null || contents.length() == 0)
        {
            contents = "[BLANK]";
        }

        ByteArrayOutputStream buffer = new ByteArrayOutputStream();

        Document document = new Document();
        PdfWriter.getInstance(document, buffer);

        document.addCreator("DWR.war using iText");
        document.open();
        document.add(new Paragraph(contents));
        document.close();

        return new FileTransfer("example.pdf", "application/pdf", buffer.toByteArray());
    }

    /**
     * Voodoo to scale the image to 200x200
     * @param uploadImage The image to work on
     * @return The altered image
     */
    private BufferedImage scaleToSize(BufferedImage uploadImage)
    {
        AffineTransform atx = new AffineTransform();
        atx.scale(200d / uploadImage.getWidth(), 200d / uploadImage.getHeight());
        // AffineTransformOp.TYPE_BILINEAR is very slow
        AffineTransformOp afop = new AffineTransformOp(atx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
        uploadImage = afop.filter(uploadImage, null);
        return uploadImage;
    }

    /**
     * And scrawl the text on the image in 10 rows of 21 chars
     * @param uploadImage The image to work on
     * @param uploadFile The text to write on the image
     * @param color The selected color
     * @return The altered image
     */
    private BufferedImage grafitiTextOnImage(BufferedImage uploadImage, String uploadFile, String color)
    {
        StringBuilder buffer = new StringBuilder();
        while (buffer.length() < 200)
        {
            buffer.append(" ");
            buffer.append(uploadFile);
        }

        Graphics2D g2d = uploadImage.createGraphics();
        for (int row = 0; row < 10; row++)
        {
            String output = null;
            if (buffer.length() > (row + 1) * CHARS_PER_LINE)
            {
                output = buffer.substring(row * CHARS_PER_LINE, (row + 1) * CHARS_PER_LINE);
            }
            else
            {
                output = buffer.substring(row * CHARS_PER_LINE);
            }

            g2d.setFont(new Font("SansSerif", Font.BOLD, 16));
            g2d.setColor(ColorUtil.decodeHtmlColorString(color));
            g2d.drawString(output, 5, (row + 1) * CHARS_PER_LINE);
        }

        return uploadImage;
    }

    /**
     * 
     */
    private static final int CHARS_PER_LINE = 21;
}