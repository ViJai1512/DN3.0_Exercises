public class TestComputerBuilder {
    public static void main(String[] args) {
        Computer basicComputer = new Computer.Builder("Intel i5", "8GB").build();
        System.out.println("Basic Computer: " + basicComputer);


        Computer highEndComputer = new Computer.Builder("Intel i9", "32GB")
                .storage("1TB SSD")
                .graphicsCard("NVIDIA RTX 3080")
                .powerSupply("750W")
                .coolingSystem("Liquid Cooling")
                .build();
        System.out.println("High-End Computer: " + highEndComputer);
    }
}
