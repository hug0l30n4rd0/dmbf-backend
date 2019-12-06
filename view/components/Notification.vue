<template>
  
  <v-alert type="info">
    {{ message }}
  </v-alert>
  
</template>

<script>
export default {
  name: 'Notification',
  props: ['message']
}
</script>