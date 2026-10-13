package com.clovis.entity.task;

import java.util.Objects;

import com.clovis.entity.EntityStatus;

/**
 * Description
 */
final class Description {

    private String aDescription;


    /**
     *
     * @param A string
     *
     * @return EntityStatus.SUCCESS if a valid string.
     * if it was blank, return EntityStatus.EMPTY_ENTRY.
     * 
     */
    public EntityStatus setDescription(final String aDescription) {

        if(Objects.isNull(aDescription)|| aDescription.isBlank() ){ return EntityStatus.EMPTY_ENTRY; }

        this.aDescription = aDescription;

        return EntityStatus.SUCCESS;

    }


    /**
     *
     *  @param void.
     *
     *  @return return a string; 
     *
     */
    public String getaDescription() {
       return aDescription;
    }

}
