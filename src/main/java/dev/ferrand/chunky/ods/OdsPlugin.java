package dev.ferrand.chunky.ods;

import org.odftoolkit.odfdom.type.Color;
import org.odftoolkit.simple.SpreadsheetDocument;
import org.odftoolkit.simple.table.Cell;
import org.odftoolkit.simple.table.Row;
import org.odftoolkit.simple.table.Table;
import se.llbit.chunky.Plugin;
import se.llbit.chunky.main.Chunky;
import se.llbit.chunky.main.ChunkyOptions;
import se.llbit.chunky.renderer.export.PictureExportFormats;
import se.llbit.chunky.ui.ChunkyFx;

public class OdsPlugin implements Plugin {
  @Override
  public void attach(Chunky chunky) {
    PictureExportFormats.registerFormat(new OdsExportFormat());
  }

  public static void main(String[] args) {
    // Start Chunky normally with this plugin attached.
    Chunky.loadDefaultTextures();
    Chunky chunky = new Chunky(ChunkyOptions.getDefaults());
    new OdsPlugin().attach(chunky);
    ChunkyFx.startChunkyUI(chunky);
  }
}
