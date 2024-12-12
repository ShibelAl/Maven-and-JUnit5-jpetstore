package com.jpetstore.pages;

public enum PetCategories {

    FISH("Fish"),
    CATS("Cats"),
    DOGS("Dogs"),
    REPTILES("Reptiles"),
    BIRDS("Birds");

    private final String petCategory;

    // Constructor to initialize the category name
    PetCategories(String petCategory) {
        this.petCategory = petCategory;
    }

    // Getter to retrieve the category name
    public String getPetCategory() {
        return petCategory;
    }
}
