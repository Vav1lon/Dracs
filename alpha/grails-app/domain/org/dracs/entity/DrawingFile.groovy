package org.dracs.entity

class DrawingFile {

    String name
    String extension
    Double size
    File file
    String hash
    Drawing drawing

    static hasMany = [attributes: DrawingAttribute, materials: DrawingMaterial]

    static mapping = {
        id generator: 'sequence', params: [sequence: 'drawing_file_id_seq', initialValue: 1, allocationSize: 1]
        attributes cascade: 'all'
        materials cascade: 'all'
    }

    static constraints = {
        hash size: 1..33
        materials nullable: true
        drawing nullable: true
    }

}
