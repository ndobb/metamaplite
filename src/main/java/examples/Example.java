//
package examples;

import bioc.BioCDocument;
import bioc.BioCSentence;
import gov.nih.nlm.nls.metamap.document.FreeText;
import gov.nih.nlm.nls.metamap.lite.types.Entity;
import gov.nih.nlm.nls.metamap.lite.types.EntityTokenList;
import gov.nih.nlm.nls.metamap.lite.types.Ev;
import gov.nih.nlm.nls.ner.MetaMapLite;
import java.util.List;
import java.util.ArrayList;
import java.util.Properties;
import java.lang.reflect.InvocationTargetException;
import java.io.IOException;

/**
 * Example of using metaMapLite from Java
 */

public class Example {
    /** log4j logger instance */
    // private static final Logger logger = LoggerFactory.getLogger(Example.class);

    /**
     * Main program
     * 
     * @param args - Arguments passed from the command line
     * @throws Exception                 General exception
     * @throws ClassNotFoundException    Class Not Found Exception
     * @throws IOException               IO Exception
     * @throws NoSuchMethodException     no method in class
     * @throws IllegalAccessException    illegal access of class
     * @throws InstantiationException    exception while instantiating class
     * @throws InvocationTargetException invocation target exception
     */
    public static void main(String[] args) throws Exception, IOException, ClassNotFoundException,
            InstantiationException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        // Initialization Section
        String pwd = "/Users/nicdobbins/work/nlp/metamaplite";
        Properties myProperties = MetaMapLite.getDefaultConfiguration();
        myProperties.setProperty("metamaplite.index.directory", pwd + "/data/ivf/2020AA/USAbase");
        myProperties.setProperty("metamaplite.excluded.termsfile", pwd + "/data/specialterms.txt");
        myProperties.setProperty("metamaplite.enable.postagging", "false");
        myProperties.setProperty("metamaplite.detect.negations", "false");
        myProperties.setProperty("metamaplite.enable.scoring", "false");
        myProperties.setProperty("metamaplite.cuitermlistfile.filename", pwd + "/data/cuitermlist.txt");
        MetaMapLite.expandModelsDir(myProperties, pwd + "/data/models");
        MetaMapLite.expandIndexDir(myProperties, pwd + "/data/ivf/2020AA/USAbase");

        MetaMapLite metaMapLiteInst = new MetaMapLite(myProperties);

        String phrase = "Has diabetes but not chronic hypertension dancing.";
        BioCSentence sentence = new BioCSentence();
        sentence.setText(phrase);
        EntityTokenList entityList = metaMapLiteInst.processSimpleSentence(sentence);

        for (Entity entity : entityList.getEntities()) {
            System.out.println(entity.getMatchedText());
            for (Ev ev : entity.getEvSet()) {
                System.out.println(ev);
            }
            System.out.println();
        }
    }
}
