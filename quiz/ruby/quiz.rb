#!/usr/bin/env ruby

require 'json'

questions = JSON.load(File.open("../questions.json"))

questions.each.with_index(1) do |question, i|
  puts "Question ##{i}\n"
  puts question['text']
  question['choices'].each do |(letter, choice)|
    puts "#{letter}) #{choice}"
  end
  puts "\n"
  print "Your Answer: "

  answer = gets.strip.upcase

  if answer == question['answer']
    puts "Correct!"
  else
    puts "WRONG"
  end

  puts "\n\n"
end
