//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.8-b130911.1802 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2020.02.18 a las 10:33:24 AM CET 
//


package clases;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the clases package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: clases
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Receta }
     * 
     */
    public Receta createReceta() {
        return new Receta();
    }

    /**
     * Create an instance of {@link Receta.Alternativo }
     * 
     */
    public Receta.Alternativo createRecetaAlternativo() {
        return new Receta.Alternativo();
    }

    /**
     * Create an instance of {@link Recetario }
     * 
     */
    public Recetario createRecetario() {
        return new Recetario();
    }

    /**
     * Create an instance of {@link Medico }
     * 
     */
    public Medico createMedico() {
        return new Medico();
    }

    /**
     * Create an instance of {@link clases.Medicamento }
     * 
     */
    public clases.Medicamento createMedicamento() {
        return new clases.Medicamento();
    }

    /**
     * Create an instance of {@link Receta.Alternativo.Medicamento }
     * 
     */
    public Receta.Alternativo.Medicamento createRecetaAlternativoMedicamento() {
        return new Receta.Alternativo.Medicamento();
    }

}
