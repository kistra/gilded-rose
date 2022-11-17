package gildedrose;

class GildedRose {

	Item[] items;

	public GildedRose(Item[] items) {
		this.items = items;
	}

	private void changeQuality(int index, int quality) {
		items[index].quality = items[index].quality + quality;
	}

	private int resolveQuality(int index) {
		if (!items[index].name.equals("Aged Brie")
				&& !items[index].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
			if (items[index].quality > 0) {
				if (items[index].name.equals("Conjured Mana Cake")) {
					return -2;
				} else if (!items[index].name.equals("Sulfuras, Hand of Ragnaros")) {
					return -1;
				}
			}
		} else {
			if (items[index].quality < 50) {
				return 1;
				if (items[index].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
					if (items[index].sellIn < 11) {
						if (items[index].quality < 50) {
							return 1;
						}
					}

					if (items[index].sellIn < 6) {
						if (items[index].quality < 50) {
							return 1;
						}
					}
				}
			}
		}
	}

	public void updateQuality() {
		for (int i = 0; i < items.length; i++) {


			if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
				items[i].sellIn = items[i].sellIn - 1;
			}

			if (items[i].sellIn < 0) {
				if (!items[i].name.equals("Aged Brie")) {
					if (!items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
						if (items[i].quality > 0) {
							if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
								changeQuality(i, -1);
							}
						}
					} else {
						items[i].quality = 0;
					}
				} else {
					if (items[i].quality < 50) {
						changeQuality(i, 1);
					}
				}
			}
		}
	}
}
