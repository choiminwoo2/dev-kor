/** @type {import('tailwindcss').Config} */
export default {
  content: ['./src/**/*.{html,js,svelte,ts}'],
  theme: {
    fontFamily: {
      pre: ['Pretendard'],
    },
    extend:{
      backgroundColor: {
        'bgBlue' :{
          'custom' : '#79A1DF',
          'hover' : '#2E6FD1'
        }
      }
    },
  },
  plugins: [
    function({ addUtilities }) {
      addUtilities({
        '.hide-scrollbar::-webkit-scrollbar': {
          display: 'none',
        },
      });
    },
  ],
}

