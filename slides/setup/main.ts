// setup/main.ts
import { defineAppSetup } from '@slidev/types'
import FigureWithCaption from '../components/FigureWithCaption.vue'

export default defineAppSetup(({ app }) => {
  app.component('FigureWithCaption', FigureWithCaption)
})
