**The drone driver**

user stories:
  - developer will receive:
    - coordinates
    - range (int): area with size 

  - drone will receive:
    - collection of urbanization to visit
        
method to implement:
  - obtenerUrbanizaciones
    - input
      - coordinate
      - range
    - output
      - list of Urbanization in that range
    
assumptions:
  - ranges are include inside each other, i.e. range 2 contains range.
  - the map of areas is static, so cannot be changed after initialization.
  - the distance to measure from the origin is round, forming a circumference.
  
  
  
