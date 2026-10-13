package com.clovis.entity.task;

import java.util.Objects;

import com.clovis.entity.EntityStatus;

/**
 * Title
 */
final public class Title {

    private String title;

    /**
     *
     * @param A string
     *
     * @return EntityStatus.SUCCESS if a valid string.
     * if it was blank, return EntityStatus.EMPTY_ENTRY.
     * 
     */
    public EntityStatus setTitle(final String title) {

        if( Objects.isNull(title)|| title.isBlank()){ return EntityStatus.EMPTY_ENTRY; }

        this.title = title;

        return EntityStatus.SUCCESS;

    }

    /**
     *
     *  @param void.
     *
     *  @return return a string; 
     *
     */
    public String getTitle() {
        return title;
    }
    
}
