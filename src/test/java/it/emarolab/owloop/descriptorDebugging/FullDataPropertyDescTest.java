package it.emarolab.owloop.descriptorDebugging;

import it.emarolab.owloop.descriptor.utility.dataPropertyDescriptor.FullDataPropertyDesc;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * A Unit Test script for data property descriptor.
 * <p>
 * <div style="text-align:center;"><small>
 * <b>File</b>:        it.emarolab.owloop.descriptor.utility.dataPropertyDescriptor <br>
 * <b>Licence</b>:     GNU GENERAL PUBLIC LICENSE. Version 3, 29 June 2007 <br>
 * <b>Author</b>:      Buoncompagni Luca (luca.buoncompagni@edu.unige.it) <br>
 * <b>affiliation</b>: DIBRIS, EMAROLab, University of Genoa. <br>
 * <b>date</b>:        10/07/19 <br>
 * </small></div>
 *
 */
public class FullDataPropertyDescTest {

    public static String DEBUGGING_PATH = "src/test/resources/debug/";

    private static FullDataPropertyDesc dataProperty;

    @Before // called a before every @Test
    public void setUp() throws Exception {
        dataProperty = new FullDataPropertyDesc(
                "has_time", // the ground instance name
                "ontoName", // ontology reference name
                DEBUGGING_PATH + "ontology4debugging.owl", // the ontology file path
                "http://www.semanticweb.org/emaroLab/luca-buoncompagni/sit" // the ontology IRI path
        );
    }

    @AfterClass // called after all @Test-s
    public static void save() throws Exception{
        dataProperty.saveOntology( DEBUGGING_PATH + "dataPropertyTest.owl");
    }


    @Test
    public void subTest() throws Exception {
        dataProperty.readExpressionAxioms();
        assertSemantic();
        dataProperty.addSubDataProperty( "hasSubProperty");
        dataProperty.readExpressionAxioms();
        assertSemantic();
        dataProperty.writeExpressionAxioms();
        assertSemantic();
        dataProperty.addSubDataProperty( "hasSubProperty");
        dataProperty.writeExpressionAxioms();
        assertSemantic();
        dataProperty.removeSubDataProperty( "hasSubProperty");
        dataProperty.readExpressionAxioms();
        assertSemantic();
        dataProperty.removeSubDataProperty( "hasSubProperty");
        dataProperty.writeExpressionAxioms();
        assertSemantic();

        dataProperty.addSubDataProperty( "subDataPropertyToBuild");
        dataProperty.writeExpressionAxioms();
        assertSemantic();
        System.out.println( "described data property, sub test: " + dataProperty.buildSubDataProperties());
    }


    @Test
    public void superTest() throws Exception {
        dataProperty.readExpressionAxioms();
        assertSemantic();
        dataProperty.addSuperDataProperty("hasSuperProperty");
        dataProperty.readExpressionAxioms();
        assertSemantic();
        dataProperty.writeExpressionAxioms();
        assertSemantic();
        dataProperty.addSuperDataProperty( "hasSuperProperty");
        dataProperty.writeExpressionAxioms();
        assertSemantic();
        dataProperty.removeSuperDataProperty( "hasSuperProperty");
        dataProperty.readExpressionAxioms();
        assertSemantic();
        dataProperty.removeSuperDataProperty( "hasSuperProperty");
        dataProperty.writeExpressionAxioms();
        assertSemantic();

        dataProperty.addSuperDataProperty( "superDataPropertyToBuild");
        dataProperty.writeExpressionAxioms();
        assertSemantic();
        System.out.println( "described data property, super test: " + dataProperty.buildSuperDataProperties());
    }

    @Test
    public void disjointTest() throws Exception {
        dataProperty.readExpressionAxioms();
        assertSemantic();
        dataProperty.addDisjointDataProperty("hasDisjointProperty");
        dataProperty.readExpressionAxioms();
        assertSemantic();
        dataProperty.writeExpressionAxioms();
        assertSemantic();
        dataProperty.addDisjointDataProperty( "hasDisjointProperty");
        dataProperty.writeExpressionAxioms();
        assertSemantic();
        dataProperty.removeDisjointDataProperty( "hasDisjointProperty");
        dataProperty.readExpressionAxioms();
        assertSemantic();
        dataProperty.removeDisjointDataProperty( "hasDisjointProperty");
        dataProperty.writeExpressionAxioms();
        assertSemantic();

        dataProperty.addDisjointDataProperty( "disjointDataPropertyToBuild");
        dataProperty.writeExpressionAxioms();
        assertSemantic();
        System.out.println( "described data property, disjoint test: " + dataProperty.buildDisjointDataProperties());
    }

    @Test
    public void equivalentTest() throws Exception {
        dataProperty.readExpressionAxioms();
        assertSemantic();
        dataProperty.addEquivalentDataProperty("hasEquivalentProperty");
        dataProperty.readExpressionAxioms();
        assertSemantic();
        dataProperty.writeExpressionAxioms();
        assertSemantic();
        dataProperty.addEquivalentDataProperty( "hasEquivalentProperty");
        dataProperty.writeExpressionAxioms();
        assertSemantic();
        dataProperty.removeEquivalentDataProperty( "hasEquivalentProperty");
        dataProperty.readExpressionAxioms();
        assertSemantic();
        dataProperty.removeEquivalentDataProperty( "hasEquivalentProperty");
        dataProperty.writeExpressionAxioms();
        assertSemantic();

        dataProperty.addEquivalentDataProperty( "equivalentDataPropertyToBuild");
        dataProperty.writeExpressionAxioms();
        assertSemantic();
        System.out.println( "described data property, equivalent test: " + dataProperty.buildEquivalentDataProperties());
    }

    @Test
    public void domainTest() throws Exception{

        dataProperty.readExpressionAxioms();
        dataProperty.getDomainRestrictions().clear();
        dataProperty.writeExpressionAxioms();

        dataProperty.addDomainClassRestriction("Sphere");
        dataProperty.addDomainClassRestriction("Plane");
        dataProperty.writeReadExpressionAxioms();
        assertSemantic();

        dataProperty.removeDomainClassRestriction("Sphere");
        dataProperty.removeDomainExactDataRestriction("has_time", 1, Long.class);
        dataProperty.writeReadExpressionAxioms();
        assertSemantic();

        dataProperty.addDomainSomeDataRestriction("has_time", Long.class);
        dataProperty.addDomainSomeDataRestriction("has_time_stamp", String.class);
        dataProperty.writeReadExpressionAxioms();
        assertSemantic();

        dataProperty.readExpressionAxioms();
        assertSemantic();
        dataProperty.addDomainClassRestriction("Sphere");
        dataProperty.readExpressionAxioms();
        assertSemantic();
        dataProperty.writeReadExpressionAxioms();
        assertSemantic();
        dataProperty.addDomainClassRestriction( "Sphere");
        dataProperty.writeReadExpressionAxioms();
        assertSemantic();
        dataProperty.removeDomainClassRestriction( "Sphere");
        dataProperty.readExpressionAxioms();
        assertSemantic();
        dataProperty.removeDomainClassRestriction( "Sphere");
        dataProperty.writeReadExpressionAxioms();
        assertSemantic();

        dataProperty.addDomainClassRestriction( "ClassRestrictionTest");
        dataProperty.writeReadExpressionAxioms();
        assertSemantic();



        dataProperty.readExpressionAxioms();
        assertSemantic();
        dataProperty.addDomainExactDataRestriction( "hasDomainProperty", 3, Long.class);
        dataProperty.readExpressionAxioms();
        assertSemantic();
        dataProperty.writeReadExpressionAxioms();
        assertSemantic();
        dataProperty.addDomainExactDataRestriction( "hasDomainProperty", 3, Long.class);
        dataProperty.writeReadExpressionAxioms();
        assertSemantic();
        dataProperty.removeDomainExactDataRestriction( "hasDomainProperty", 3, Long.class);
        dataProperty.readExpressionAxioms();
        assertSemantic();
        dataProperty.removeDomainExactDataRestriction( "hasDomainProperty", 3, Long.class);
        dataProperty.writeReadExpressionAxioms();
        assertSemantic();

        dataProperty.addDomainMinDataRestriction( "hasDomainDataPropertyTest", 3, Double.class);
        dataProperty.writeReadExpressionAxioms();
        assertSemantic();

        dataProperty.readExpressionAxioms();
        assertSemantic();
        dataProperty.addDomainExactObjectRestriction( "hasDomainProperty", 3, "Plane");
        dataProperty.readExpressionAxioms();
        assertSemantic();
        dataProperty.writeReadExpressionAxioms();
       assertSemantic();
        dataProperty.addDomainExactObjectRestriction( "hasDomainProperty", 3, "Plane");
        dataProperty.addDomainExactObjectRestriction( "hasDomainProperty", 3, "Plane");
        dataProperty.writeReadExpressionAxioms(); // the reasoner always infers here
        assertSemantic();
        dataProperty.removeDomainExactObjectRestriction( "hasDomainProperty", 3, "Plane");
        dataProperty.readExpressionAxioms();
       assertSemantic();
        dataProperty.removeDomainExactObjectRestriction( "hasDomainProperty", 3, "Plane");
        dataProperty.writeReadExpressionAxioms(); // the reasoner always infers here
        assertSemantic();

        dataProperty.addDomainMaxObjectRestriction( "hasDomainDataPropertyTest1", 2, "Cone");
        dataProperty.writeReadExpressionAxioms(); // the reasoner always infers here
       assertSemantic();
        System.out.println( "described data property, domain test: " + dataProperty.getDomainRestrictions());

    }


    @Test
    public void rangeTest() throws Exception{
        dataProperty.setGroundInstance( "testPropRange");

        dataProperty.readExpressionAxioms();
        assertSemantic();
        dataProperty.addRangeDataRestriction( Long.class);
        dataProperty.readExpressionAxioms();
        assertSemantic();
        dataProperty.writeExpressionAxioms();
        assertSemantic();
        dataProperty.addRangeDataRestriction( String.class);
        dataProperty.writeReadExpressionAxioms();
        assertSemantic();
        dataProperty.removeRangeDataRestriction( String.class);
        dataProperty.readExpressionAxioms();
        assertSemantic();
        dataProperty.removeRangeDataRestriction( Integer.class);
        // the reasoner infer no more disjoint here since there is no more range restriction
        dataProperty.writeReadExpressionAxioms();
        assertSemantic();

        dataProperty.addRangeDataRestriction( Boolean.class);
        // the reasoner infer disjoint here since there is a range restriction
        dataProperty.writeReadExpressionAxioms();
        assertSemantic();

        System.out.println( "described object property, range test: " + dataProperty.getRangeRestrictions());
    }

    int cnt = 0;
    public void assertSemantic(){ // asserts that the state of the java representation is equal to the state of the ontology
        System.out.println( ++cnt + " ->   " + dataProperty);
        assertEquals( dataProperty.getSubDataProperties(), dataProperty.querySubDataProperties());
        assertEquals( dataProperty.getSuperDataProperties(), dataProperty.querySuperDataProperties());
        assertEquals( dataProperty.getDisjointDataProperties(), dataProperty.queryDisjointDataProperties());
        assertEquals( dataProperty.getEquivalentDataProperties(), dataProperty.queryEquivalentDataProperties());
        assertEquals( dataProperty.getDomainRestrictions(), dataProperty.queryDomainRestrictions());
        assertEquals( dataProperty.getRangeRestrictions(), dataProperty.queryRangeRestrictions());
    }
}
