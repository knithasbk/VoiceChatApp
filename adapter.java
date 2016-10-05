@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    //Now for the list view

    ListView listView=(ListView)findViewById(R.id.listView);

    String[] values =new String[]{"iOS","android","firefoxOs","Ubuntu"};

   MySimpleAdapter simpleAdapter=new MySimpleAdapter(this,values);

   listView.setAdapter(simpleAdapter);
    //

    }

@Override
public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.menu_main, menu);
    return true;
}

@Override
public boolean onOptionsItemSelected(MenuItem item) {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    int id = item.getItemId();

    //noinspection SimplifiableIfStatement
    if (id == R.id.action_settings) {
        return true;
    }

    return super.onOptionsItemSelected(item);
}

class MySimpleAdapter extends ArrayAdapter<String>{

    private Context context;
    private String[] values;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
    //listView calls this on its adapter for each row
        Log.v("list","getView");
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView=inflater.inflate(R.layout.custom_row,parent,false);

        TextView textView1= (TextView) rowView.findViewById(R.id.textView1);

        textView1.setText(values[position]);
        //for the android row alone set an image , others leave it as blank
        if(values[position].startsWith("and"))
        {
            ImageView imageView=(ImageView)rowView.findViewById(R.id.imageView);
            imageView.setImageResource(R.drawable.ic_launcher);//Ok R.drawale....is also an id
        }


        return rowView;
    }

    public MySimpleAdapter(Context context,String[] values) {
        super(context, R.layout.custom_row,values);

        this.context=context;
        this.values=values;
        Log.v("list","constructor");
    }
}