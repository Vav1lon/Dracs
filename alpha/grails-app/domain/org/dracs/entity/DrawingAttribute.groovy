package org.dracs.entity

class DrawingAttribute {

    String key
    String value
    int index
    long type
    String documentName

    static belongsTo = DrawingFile

    static mapping = {
        id generator: 'sequence', params: [sequence: 'drawing_attribute_id_seq', initialValue: 1, allocationSize: 1]
        index sort: 'asc'
    }

    static constraints = {
        key nullable: true
        value nullable: true
    }

}
