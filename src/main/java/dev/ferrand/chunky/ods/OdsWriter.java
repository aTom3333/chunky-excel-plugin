package dev.ferrand.chunky.ods;

import org.odftoolkit.odfdom.type.Color;
import org.odftoolkit.simple.SpreadsheetDocument;
import org.odftoolkit.simple.table.Cell;
import org.odftoolkit.simple.table.Table;
import se.llbit.chunky.resources.BitmapImage;

import java.io.IOException;
import java.io.OutputStream;

public class OdsWriter {
  private static Color blur5(int[] data, int start) {
    int r = 0, g = 0, b = 0;
    for(int i = 0; i < 5; ++i) {
      int c = data[start+i];
      r += (c >> 16) & 0xff;
      g += (c >> 8) & 0xff;
      b += c & 0xff;
    }
    return new Color(r/5, g/5, b/5);
  }

  public static void write(OutputStream out, BitmapImage image) {
    SpreadsheetDocument sheet = null;
    try {
      sheet = SpreadsheetDocument.newSpreadsheetDocument();
    } catch(Exception e) {
      throw new RuntimeException(e);
    }
    Table table = sheet.getSheetByIndex(0);
    for(int y = 0; y < image.height; ++y) {
      for(int x = 0; x < image.width/5; ++x) {
        Cell cell = table.getCellByPosition(x, y);
        cell.setCellBackgroundColor(blur5(image.data, image.width*y + x*5));
      }
    }
    try {
      sheet.save(out);
    } catch(Exception e) {
      throw new RuntimeException(e);
    }
  }
}
