class ObjectSerializationTest {

	public static void main(String[] args) throws Exception {
		var store = new tourism.SiteObjectStore();
		var zoo = store.fetch("CitiZoo");
		if(args.length > 0){
			String name = args[0].toLowerCase(); 
			var visitor = zoo.getVisitor(name);
			visitor.visit();
			store.persist(zoo);
			System.out.printf("Welcome %s, your current visit token is %d%n", name, visitor.getCurrentVisitToken());
		}else{
			for(var i : zoo.getVisitors())
				System.out.printf("%s\t%d\t%s%n", i.getId(), i.getVisitCount(), i.getLastVisit());
		}
	}
}


