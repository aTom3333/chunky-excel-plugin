package dev.ferrand.chunky.ods;

import se.llbit.chunky.renderer.export.PictureExportFormat;
import se.llbit.chunky.renderer.scene.Scene;
import se.llbit.util.TaskTracker;

import java.io.IOException;
import java.io.OutputStream;

public class OdsExportFormat implements PictureExportFormat {
  @Override
  public String getDescription() {
    return "ODS (excel -or similar- file)";
  }

  @Override
  public boolean isTransparencySupported() {
    return false;
  }

  @Override
  public String getName() {
    return "ODS";
  }

  @Override
  public String getExtension() {
    return ".ods";
  }

  @Override
  public void write(OutputStream outputStream, Scene scene, TaskTracker taskTracker) throws IOException {
    OdsWriter.write(outputStream, scene.getBackBuffer());
  }
}
