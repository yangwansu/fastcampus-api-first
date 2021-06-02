package org.masil.api.codegen;

import io.swagger.v3.oas.models.media.Schema;
import org.openapitools.codegen.CodegenConfig;
import org.openapitools.codegen.CodegenModel;
import org.openapitools.codegen.languages.SpringCodegen;

public class MasilSpringGenerator extends SpringCodegen implements CodegenConfig {

  public MasilSpringGenerator() {
    super();
    embeddedTemplateDir = templateDir = "masilspring";
  }

  /**
   * Configures a friendly name for the generator.  This will be used by the generator
   * to select the library with the -g flag.
   * 
   * @return the friendly name for the generator
   */
  public String getName() {
    return "masilspring";
  }


  @Override
  public void processOpts() {
    super.processOpts();
    // imports for pojos
    importMapping.remove("ApiModelProperty");
    importMapping.remove("ApiModel");
  }

  @Override
  public CodegenModel fromModel(String name, Schema model) {
    super.fromModel(name, model);
    CodegenModel codegenModel = super.fromModel(name, model);
    codegenModel.imports.remove("ApiModel");
    codegenModel.imports.remove("ApiModelProperty");
    return codegenModel;
  }
}