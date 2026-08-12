# Humble Furniture

A Minecraft Fabric mod for 26.2.

## Installing the mod (for players)

Requires:
- [Fabric Loader](https://fabricmc.net/use/) >= 0.19.3
- [Fabric API](https://modrinth.com/mod/fabric-api) matching Minecraft 26.2
- Minecraft 26.2 running on Java 25+

Steps:
1. Download the mod jar from [Modrinth](https://modrinth.com/) (TODO: link once the project is published) or this repo's [Releases](https://github.com/sspanna/humble_furniture_mod/releases) page.
2. Drop the jar into your `.minecraft/mods` folder.
3. Launch Minecraft with the Fabric profile.

## Setup

Requires [SDKMAN](https://sdkman.io) and git.

    git clone git@github.com:sspanna/humble_furniture_mod.git
    cd humble_furniture_mod
    sdk env install     # installs the pinned JDK from .sdkmanrc
    ./gradlew runClient  # launches a dev Minecraft with the mod loaded

## Build a distributable jar

    ./gradlew build      # output lands in build/libs/
