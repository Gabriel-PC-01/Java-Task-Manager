package com.clovis.entity;

/**
 * EntityStatus
 */
public enum EntityStatus {

    EMPTY_ENTRY{
        @Override
        public void throwException(String message) throws Exception{
           
            throw new IllegalArgumentException(message);

        }
    },
    INVALID_ENTRY{
        @Override
        public void throwException(String message) throws Exception{
           throw new IllegalArgumentException(message); 
        }
    };


    public abstract void throwException(String message) throws Exception;
}
