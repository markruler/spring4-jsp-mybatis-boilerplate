import { defineConfig, Plugin, ResolvedConfig, Rollup } from "vite";
import react from "@vitejs/plugin-react";

import fs from "fs";
import path from "path";

function viteJspPlugin(): Plugin {
  let resolvedConfig: ResolvedConfig;

  return {
    name: "vite-jsp-plugin",
    configResolved(config: ResolvedConfig) {
      resolvedConfig = config;
    },
    writeBundle(
      this,
      options: Rollup.NormalizedOutputOptions,
      bundle: Rollup.OutputBundle
    ) {
      const jsFiles = Object.keys(bundle).filter((fileName) =>
        fileName.endsWith(".js")
      );
      const cssFiles = Object.keys(bundle).filter((fileName) =>
        fileName.endsWith(".css")
      );

      if (!options.dir || options.dir === "") {
        throw new Error("Error: options.dir field has not been created.");
      }

      const jspContent = ['<div id="root"></div>'];

      cssFiles.forEach((file) => {
        const style = `<link rel="stylesheet" href="${
          resolvedConfig.base ? resolvedConfig.base + file : file
        }" />`;
        jspContent.push(style);
      });

      jsFiles.forEach((file) => {
        jspContent.push(
          `<script type="module" src="${
            resolvedConfig.base ? resolvedConfig.base + file : file
          }"></script>`
        );
      });

      fs.writeFileSync(
        path.resolve(options.dir, "index.jsp"),
        jspContent.join("")
      );
    },
  };
}

export default defineConfig({
  plugins: [react(), viteJspPlugin()],
  base: "/c",
});
