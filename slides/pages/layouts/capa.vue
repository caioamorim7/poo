<template>
  <div class="w-full h-full grid grid-cols-3">
    <div class="col-span-2 flex flex-col justify-center pl-20 bg-white text-center">
      <p class="text-4xl font-bold text-gray-500 mb-4">Programação Orientada a Objetos com Java</p>
      <p class="text-2xl text-gray-400 mb-4">{{ $slidev.configs.class}}</p>

      <div class="col-span-2 flex flex-col text-gray-600 justify-center pl-20 bg-white" v-if="$slidev.configs.goals && $slidev.configs.goals.length > 0">
        <p class="text-lg font-semibold mb-2 text-left">Objetivos da aula</p>
        <ul class="list-disc list-inside space-y-1 text-sm text-left">
          <li v-for="(goal, index) in $slidev.configs.goals" :key="index">{{ goal }}</li>
        </ul>
      </div>
      
    </div>
    <div class="bg-blue-900 text-white flex flex-col justify-end items-start px-6 pb-4">
      <p class="text-sm text-gray-400 mb-1">2025.2</p>
      <p class="text-sm text-gray-400 mb-1">Prof. Fabricio Santana</p>
      <p class="text-sm text-gray-400 mb-1">fabricio.santana@idp.edu.br</p>
      <p class="text-sm text-gray-400 mb-1">www.linkedin.com/in/fabriciofsantana</p>
    </div>
  </div>
</template>
