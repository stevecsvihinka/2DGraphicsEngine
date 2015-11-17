The command line program 2D geometry fans have been clamoring for: draw and transform polygons from your command line  

## Docs:


######Creating a polygon: 


**polygon(x1, y1, x2, y2, …, xn, yn)**


This creates a polygon with n vertices. If a polygon already exists, it simply replaces	it. If the operation is	
successful,	the	program prints OK. Note that, for each x value, the polygon must have a corresponding y value (therefore the 'polygon' command must accept an even number of arguments).
___


######Displaying the polygon:


**show**


This operation takes no	arguments, creates a window displaying the polygon, and prints the current vertices of the polygon in the form:


(x1, y1, x2, y2, …, xn, yn)


If arguments are passed to the 'show' command, it will simply ignore them.
___


######Translate:


**T(tx, ty)**


This translates	the	polygon by vector (tx, ty). If more than two arguments are passed to the 'translate' command, it will recognize the first two and ignore proceeding arguments.
___


######Rotate:


**R(theta)**


This rotates the polygon around	its	centroid theta degrees. If more than one argument is passed to the 'rotate' command, it will recognize the initial and ignore proceeding arguments.
___


######Scale:


**S(xs, ys)**


This performs a scaling of the polygon with factors xs and ys, using the polygon's centroid as a fixed point. If more than two arguments are passed to the 'scale' command, it will recognize the first two and ignore proceeding arguments.
___


######Terminating the program:


**exit**


Terminates the program


	