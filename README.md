This is a test task for a JetBrains internship project.

An extension that adds an action "Hello World Action" to Search Everywhere menu

## Using the extension

1. Download the plugin archive from the Releases section
2. Install by going in Settings -> Plugins -> ... -> Install plugin from disk and selecting the plugin file
3. To use the action type "Hello World Action" in Search Everywhere menu (double shift)

## Development setup

1. Open project in IntelliJ IDEA
2. Run `runIde` task

## Building the plugin

1. Run `buildPlugin` task
2. The built plugin will be saved to `build/distributions` directory

## Testing

1. Run `clean` task, then `runIdeForUiTests`. It should continue running in the background.
2. Open/create any project in the opened IDE
3. Run `test` task

