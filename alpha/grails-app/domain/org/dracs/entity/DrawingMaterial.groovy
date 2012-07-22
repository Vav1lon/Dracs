package org.dracs.entity

class DrawingMaterial {

    String name
    String description

    static belongsTo = DrawingFile

    static constraints = {
        description nullable: true
    }

}
