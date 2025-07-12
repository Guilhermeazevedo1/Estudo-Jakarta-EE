package wildflyconfig.config;


/*
Como fazer o Config funcionar:

1. Botão direito no projeto → Build Path > Configure Build Path.

2. Aba Libraries → clique em Add External JARs...

3. Selecione o JAR do CDI (cdi-api.jar) que está em:

wildfly-19.1.0.Final/modules/system/layers/base/javax/enterprise/api/main/

4. Depois de adicionar, clique em cima dele e escolha "Move to Classpath" (se ele tiver ido pro Modulepath por engano).

5. Clique em Apply and Close.
*/

import javax.enterprise.context.ApplicationScoped;
import javax.faces.annotation.FacesConfig;
import javax.faces.annotation.FacesConfig.Version;

@FacesConfig(version = Version.JSF_2_3)
@ApplicationScoped
public class Config {
	
}
