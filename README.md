## Scala.Js - Vite project template

----------------

## Usage

This is a sbt project configured specifically for Scala.Js and Vite.

### Adding new dependencies

To add new dependencies, do it with `yarn add ${dependencyName}` or if you use npm `npm install ${dependencyName}`

### Starting dev server

To start Scala.Js - Vite developement server, you first need to start incremental compilation for code.
It is done by running `sbt ~fastLinkJS` directly from shell of just `~fastLinkJS` from SBT shell instance.
The next step is to start the server. To do it, run `yarn dev` or if you use npm `npm run dev` in your terminal.
