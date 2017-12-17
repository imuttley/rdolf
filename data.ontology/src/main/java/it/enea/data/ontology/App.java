package it.enea.data.ontology;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.vocabulary.DC;

/**
 * Test GRAPH
 *
 */
public class App 
{
	static final String nsURI    = "http://neruon4web.palermo.enea.it/";
    static final String family     = "dolphin";

  
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
       // create an empty Model
        Model model = ModelFactory.createDefaultModel();

        // create the resource
        Resource graph = model.createResource(nsURI);

        // add the property
        graph.addLiteral(DC.description, "an RDF vocabulary for mammals");

    }
}
