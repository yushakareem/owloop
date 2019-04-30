package it.emarolab.owloop.descriptor.utility.owloopPaperTests;


import it.emarolab.amor.owlInterface.OWLReferences;
import it.emarolab.owloop.descriptor.construction.descriptorGround.IndividualDescriptorGround;
import it.emarolab.owloop.descriptor.construction.descriptorEntitySet.DescriptorEntitySet;
import it.emarolab.owloop.descriptor.construction.descriptorExpression.IndividualExpression;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLNamedIndividual;

import java.util.List;

public class TypeIndividualDesc
        extends IndividualDescriptorGround
        implements IndividualExpression.Type<DefSubClassDesc> {

    private DescriptorEntitySet.Concepts individualTypes = new DescriptorEntitySet.Concepts();

    // constructors for IndividualDescriptorGround
    public TypeIndividualDesc(OWLNamedIndividual instance, OWLReferences onto) {
        super(instance, onto);
    }

    // implementations for Axiom.descriptor
    @Override
    public List<MappingIntent> readSemantic() {
        List<MappingIntent> r = Type.super.readSemantic();
        return r;
    }

    @Override
    public List<MappingIntent> writeSemantic() {
        List<MappingIntent> r = Type.super.writeSemantic();
        return r;
    }


    // implementations for IndividualExpression.Type
    @Override //called during build...() you can change the returning type to any implementations of ConceptExpression
    public DefSubClassDesc getNewTypeIndividual(OWLClass instance, OWLReferences ontology) {
        return new DefSubClassDesc( instance, ontology);
    }

    @Override
    public DescriptorEntitySet.Concepts getTypeIndividual() {
        return individualTypes;
    }


    // implementation for standard object interface
    // equals() and hashCode() is based on DescriptorGround<?> which considers only the ground
    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" +
                NL + "\t\t\t" + getGround() +
                "," + NL + "\t∈ " + individualTypes +
                NL + "}" + NL;
    }
}