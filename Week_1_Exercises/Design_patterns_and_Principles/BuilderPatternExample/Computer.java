public class Computer {
    private String CPU;
    private String RAM;

    private String storage;
    private String graphicsCard;
    private String powerSupply;
    private String coolingSystem;

    private Computer(Builder builder) {
        this.CPU = builder.CPU;
        this.RAM = builder.RAM;
        this.storage = builder.storage;
        this.graphicsCard = builder.graphicsCard;
        this.powerSupply = builder.powerSupply;
        this.coolingSystem = builder.coolingSystem;
    }

    @Override
    public String toString() {
        return "Computer [CPU=" + CPU + ", RAM=" + RAM + ", storage=" + storage + ", graphicsCard=" + graphicsCard
                + ", powerSupply=" + powerSupply + ", coolingSystem=" + coolingSystem + "]";
    }


    public static class Builder {
        private String CPU;
        private String RAM;

        private String storage;
        private String graphicsCard;
        private String powerSupply;
        private String coolingSystem;

        public Builder(String CPU, String RAM) {
            this.CPU = CPU;
            this.RAM = RAM;
        }

        public Builder storage(String storage) {
            this.storage = storage;
            return this;
        }

        public Builder graphicsCard(String graphicsCard) {
            this.graphicsCard = graphicsCard;
            return this;
        }

        public Builder powerSupply(String powerSupply) {
            this.powerSupply = powerSupply;
            return this;
        }

        public Builder coolingSystem(String coolingSystem) {
            this.coolingSystem = coolingSystem;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }
}
