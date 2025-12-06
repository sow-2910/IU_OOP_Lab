
import java.util.HashMap;
import java.util.Map;

interface DiscountPolicy {
    double discount(double totalPrice);
}

class StudentDiscount implements DiscountPolicy {
    @Override
    public double discount(double totalPrice) {
        return totalPrice * 0.15;
    }
}

class TeacherDiscount implements DiscountPolicy {
    @Override
    public double discount(double totalPrice) {
        return totalPrice * 0.20;
    }
}

class VipDiscount implements DiscountPolicy {
    @Override
    public double discount(double totalPrice) {
        return totalPrice * 0.25;
    }
}

class AlumiDiscount implements DiscountPolicy {
    @Override
    public double discount(double totalPrice) {
        return totalPrice * 0.5;
    }
}

class DiscountService {
    public double calculateDiscount(DiscountPolicy policy, double totalPrice) {
        if (policy == null) {
            System.out.println("The policy does not exits");
            return 0;
        }
        return policy.discount(totalPrice);
    }

    // Using map way
    private Map<String, DiscountPolicy> policyMap;

    public DiscountService(Map<String, DiscountPolicy> policyMap) {
        this.policyMap = policyMap;
    }

    public double calculateDiscountByMap(String userType, double totalPrice) {
        DiscountPolicy policy = policyMap.get(userType);

        if (policy != null) {
            return policy.discount(totalPrice);
        }
        return 0;

    }
}

public class Main {
    public static void main(String[] args) {
        Map<String, DiscountPolicy> discountStrategies = new HashMap<>();

        discountStrategies.put("STUDENT", new StudentDiscount());
        discountStrategies.put("TEACHER", new TeacherDiscount());
        discountStrategies.put("VIP", new VipDiscount());
        discountStrategies.put("ALUMI", new AlumiDiscount());

        DiscountService service = new DiscountService(discountStrategies);
        double totalPrice = 200;

        System.out.println("Student discount: " + service.calculateDiscountByMap("STUDENT", totalPrice));
        System.out.println("Teacher discount: " + service.calculateDiscountByMap("TEACHER", totalPrice));
        System.out.println("Vip discount: " + service.calculateDiscount(new VipDiscount(), totalPrice));
        System.out.println("Alumi discount: " + service.calculateDiscount(new AlumiDiscount(), totalPrice));
    }
}
