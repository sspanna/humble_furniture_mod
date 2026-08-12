# Humble Furniture

A Minecraft Fabric mod for 26.2.

## Setup

Requires [SDKMAN](https://sdkman.io) and git.

    git clone git@github.com:<you>/tee2026.git
    cd tee2026
    sdk env install     # installs the pinned JDK from .sdkmanrc
    ./gradlew runClient  # launches a dev Minecraft with the mod loaded

## Build a distributable jar

    ./gradlew build      # output lands in build/libs/
