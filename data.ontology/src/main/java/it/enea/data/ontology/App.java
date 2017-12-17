package it.enea.data.ontology;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.jena.ontology.OntClass;
import org.apache.jena.ontology.OntModel;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.RDFList;
import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.vocabulary.DC;
import org.apache.jena.vocabulary.RDF;

/**
 * Test GRAPH
 * 
 */
public class App {
	static final String nsURI = "http://neuron4web.palermo.enea.it/data#";
	static final String family = "dolphin";

	public static void main(String[] args) {
		System.out.println("Hello World!");
		// create an empty Model

		OntModel model = ModelFactory.createOntologyModel();

		model.setNsPrefix("myo", nsURI);
		model.setNsPrefix("dc", DC.NS);
		model.setNsPrefix("purl", "http://purl.org/");
		
		OntClass td = model.createClass(nsURI + "TimeDomain");
		td.addLabel("TimeDomain", "en");
		td.addVersionInfo("0.0");
		td.addComment("Class for time domain measures", "en");

		OntClass fd = model.createClass(nsURI + "FrequencyDomain");
		fd.addLabel("FrequencyDomain", "en");
		fd.addVersionInfo("0.0");
		fd.addComment("Class for frequency domain measures", "en");

		
		// create the resource
		Resource pippo = fd.createIndividual(nsURI + "pippo");
		Resource pluto = td.createIndividual(nsURI + "pluto");
		Resource right = model.createResource("http://purl.org/" + "cc-by");
		pippo.addLiteral(DC.title,"pippo");
		pluto.addLiteral(DC.title,"pluto");
		pippo.addProperty(DC.rights, right);
		pluto.addProperty(DC.rights, right);
		
		Resource root = model.createResource(nsURI + "filexy.wav");
		
		Resource cs = (Resource) model.createList(new RDFNode[] { pippo, pluto });
		
		root.addProperty(DC.relation,cs);
		
		
		// add the property
		// graph.addLiteral(DC.description,
		// model.createLiteral("an RDF vocabulary for mammals", "en"));
		model.write(System.out, "RDF/XML");

		try {
			model.write(new FileOutputStream("ttlfile.ttl"), "TURTLE");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
