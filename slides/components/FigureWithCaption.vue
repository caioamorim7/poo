<!-- components/FigureWithCaption.vue -->
<template>
  <figure class="w-full flex flex-col items-center justify-center text-center mt-4">
    <img 
      :src="src"
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
defineProps({
  src: String,
  alt: String,
  link: String
})
</script>
