# Game Test Swing
A game I made in 2016 using Java Swing as the rendering

## Game Settings
The game controls and framerate can be changed using the second dialog window

### Controls
WASD is the default movement controls

### Framerate
The default is 60fps, but can be changed from 5 to 240 on a 5 stepping, the player can remove the limit by setting it to the lowest 0 value

## Known Bugs

 - Changing game FPS over 240 by modifying the settings file crashes
   - Details: Game sets value from settings file to the UI which creates an error
