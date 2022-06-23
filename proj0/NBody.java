public class NBody {
    public static double readRadius(String name) {
        In in = new In(name);
        int N = in.readInt();
        double R = in.readDouble();
        return R;
    }

    public static Planet[] readPlanets(String name) {
        In in = new In(name);
        int N = in.readInt();
        double R = in.readDouble();
        int i = 0;
        Planet[] bodies = new Planet[N];
        while(i < N) {
            double xxPos = in.readDouble();
            double yyPos = in.readDouble();
            double xxVel = in.readDouble();
            double yyVel = in.readDouble();
            double mass = in.readDouble();
            String imgFileName = in.readString();
            bodies[i] = new Planet(xxPos, yyPos, xxVel, yyVel, mass, imgFileName);
            i++;
        }
        return bodies;
    }

    public static void main(String[] args) {
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        Planet[] planets = readPlanets(filename);
        double r = readRadius(filename);

        StdDraw.setXscale(-r, r);
        StdDraw.setYscale(-r, r);
        StdDraw.enableDoubleBuffering();

        int t = 0;
        while(t <= T) {
          double[] xForces = new double[planets.length];
          double[] yForces = new double[planets.length];

          for(int i = 0; i < planets.length; i++) {
              xForces[i] = planets[i].calcNetForceExertedByX(planets);
              yForces[i] = planets[i].calcNetForceExertedByY(planets);
          }

          for(int i = 0; i < planets.length; i++) {
              planets[i].update(dt, xForces[i], yForces[i]);
          }

          StdDraw.picture(0, 0, "images/starfield.jpg");

          for(int i = 0; i < planets.length; i++) {
              planets[i].draw();
          }

          StdDraw.show();
          StdDraw.pause(10);
          StdDraw.clear();

          t += dt;
        }

        StdOut.printf("%d\n", planets.length);
        StdOut.printf("%.2e\n", r);
        for (int i = 0; i < planets.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                          planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                          planets[i].yyVel, planets[i].mass, planets[i].imgFileName);
        }
    }
}
