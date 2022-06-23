public class Planet {
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;

    public Planet(double xP, double yP, double xV,
                double yV, double m, String img) {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    public Planet(Planet b) {
        xxPos = b.xxPos;
        yyPos = b.yyPos;
        xxVel = b.xxVel;
        yyVel = b.yyVel;
        mass = b.mass;
        imgFileName = b.imgFileName;
    }

    public double calcDistance(Planet b) {
        double dx = b.xxPos - xxPos;
        double dy = b.yyPos - yyPos;
        double r = Math.sqrt(dx*dx + dy*dy);
        return r;
    }

    public double calcForceExertedBy(Planet b) {
        double G = 6.67e-11;
        double r = this.calcDistance(b);
        double F = G*mass*b.mass/(r*r);
        return F;
    }

    public double calcForceExertedByX(Planet b) {
        double dx = b.xxPos - xxPos;
        double r = this.calcDistance(b);
        double F = calcForceExertedBy(b);
        double Fx = F*dx/r;
        return Fx;
    }

    public double calcForceExertedByY(Planet b) {
        double dy = b.yyPos - yyPos;
        double r = this.calcDistance(b);
        double F = calcForceExertedBy(b);
        double Fy = F*dy/r;
        return Fy;
    }

    public double calcNetForceExertedByX(Planet[] all) {
        int N = all.length;
        int i = 0;
        double Fx = 0;
        while(i < N){
            if(!this.equals(all[i])) {
                Fx += this.calcForceExertedByX(all[i]);
            }
            i++;
        }
        return Fx;
    }

    public double calcNetForceExertedByY(Planet[] all) {
        int N = all.length;
        int i = 0;
        double Fy = 0;
        while(i < N){
            if(!this.equals(all[i])) {
                Fy += this.calcForceExertedByY(all[i]);
            }
            i++;
        }
        return Fy;
    }

    public void update(double t, double Fx, double Fy) {
        xxVel = xxVel + Fx*t/mass;
        yyVel = yyVel + Fy*t/mass;
        xxPos = xxPos + xxVel*t;
        yyPos = yyPos + yyVel*t;
    }

    public void draw() {
        StdDraw.picture(xxPos, yyPos, "images/" + imgFileName);
    }
}
