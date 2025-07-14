// setup/main.ts
import { defineAppSetup } from '@slidev/types'
import FigureWithCaption from '../pages/components/FigureWithCaption.vue'
import VideoWithQuote from '../pages/components/VideoWithQuote.vue'


export default defineAppSetup(({ app }) => {
  app.component('FigureWithCaption', FigureWithCaption)
  app.component('VideoWithQuote', VideoWithQuote)
})
