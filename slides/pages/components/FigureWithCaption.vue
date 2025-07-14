<!-- components/FigureWithCaption.vue -->
<template>
  <figure class="w-full flex flex-col items-center justify-center text-center mt-4">
    <img 
      :src="computedSrc"
      :alt="alt"
      class="max-h-[300px] rounded shadow mb-2"
    />
    <figcaption class="mt-4 text-sm text-center text-gray-600">
      Fonte: 
      <a :href="link" target="_blank" class="underline text-blue-600">
        {{ link }}
      </a>
    </figcaption>
  </figure>
</template>

<script setup>

import { computed } from 'vue'

const props = defineProps({
  src: String,
  alt: String,
  link: String
})

const baseURL = import.meta.env.BASE_URL

const computedSrc = computed(() => {
  // Se for uma URL externa (http, https, //), retorna como está
  if (/^(https?:)?\/\//.test(props.src)) {
    return props.src
  }
  // Caso contrário, adiciona o baseURL (caso de imagem local)
  return `${baseURL}${props.src}`
})

</script>
