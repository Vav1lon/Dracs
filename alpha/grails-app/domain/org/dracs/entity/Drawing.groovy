package org.dracs.entity

class Drawing {

    String name
    String author
    byte[] preview
    List<DrawingFile> files

    static mapping = {
        id generator: 'sequence', params: [sequence: 'drawing_id_seq', initialValue: 1, allocationSize: 1]
    }

    static constraints = {
        preview nullable: true
    }

}
