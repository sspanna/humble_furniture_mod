# Humble Furniture

A Minecraft Fabric mod for 26.2.

## Setup

Requires [SDKMAN](https://sdkman.io) and git.

    git clone git@github.com:sspanna/humble_furniture_mod.git
    cd humble_furniture_mod
    sdk env install     # installs the pinned JDK from .sdkmanrc
    ./gradlew runClient  # launches a dev Minecraft with the mod loaded

## Build a distributable jar

    ./gradlew build      # output lands in build/libs/
