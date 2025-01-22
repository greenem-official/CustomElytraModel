
Custom Elytra Model Mod
=======

This is a mod for adding a custom model to minecraft's elytra. Using an own model or animations requires to modify the mod's code, as there is no import feature due to that being way too difficult to make with no good reason to.

Main Java Files:
============

### For Blockbench exported data (must be a "Modded Entity" project):  
org.daylight.mods.customelytra.visual.generated.WingsModelData
org.daylight.mods.customelytra.visual.generated.WingsAnimation


### For modifying how it works and controlling the animations:  
org.daylight.mods.customelytra.visual.WingsModel
  
  
### For toggling if it's active for different types of entities:
org.daylight.mods.customelytra.mixins.PlayerRendererMixin
org.daylight.mods.customelytra.mixins.HumanoidMobRendererMixin
org.daylight.mods.customelytra.mixins.ArmorStandRendererMixin
